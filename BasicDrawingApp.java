
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;

    public class BasicDrawingApp extends JFrame {

        private DrawArea drawArea;
        private JButton colorButton;
        private JButton clearButton;
        private JButton saveButton;
        private Color currentColor = Color.BLACK;

        public BasicDrawingApp() {
            setTitle("Basic Drawing Application");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(800, 600);
            setLocationRelativeTo(null); // Center the window

            // Initialize components
            drawArea = new DrawArea();
            JPanel controls = new JPanel();
            controls.setLayout(new FlowLayout(FlowLayout.LEFT));
            controls.setBorder(new EmptyBorder(5, 5, 5, 5));

            // Color Button
            colorButton = new JButton("Choose Color");
            colorButton.addActionListener(e -> {
                Color chosenColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
                if (chosenColor != null) {
                    currentColor = chosenColor;
                    drawArea.setCurrentColor(currentColor);
                    colorButton.setForeground(currentColor);
                }
            });

            // Clear Button
            clearButton = new JButton("Clear");
            clearButton.addActionListener(e -> drawArea.clear());

            // Save Button
            saveButton = new JButton("Save");
            saveButton.addActionListener(e -> saveImage());

            // Add buttons to controls panel
            controls.add(colorButton);
            controls.add(clearButton);
            controls.add(saveButton);

            // Add components to frame
            add(controls, BorderLayout.NORTH);
            add(drawArea, BorderLayout.CENTER);
        }

        private void saveImage() {
            BufferedImage image = drawArea.getImage();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Image");
            FileNameExtensionFilter pngFilter = new FileNameExtensionFilter("PNG Image", "png");
            fileChooser.addChoosableFileFilter(pngFilter);
            fileChooser.setFileFilter(pngFilter);

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                try {
                    File fileToSave = fileChooser.getSelectedFile();
                    // Ensure the file has a .png extension
                    if (!fileToSave.getName().toLowerCase().endsWith(".png")) {
                        fileToSave = new File(fileToSave.getAbsolutePath() + ".png");
                    }
                    ImageIO.write(image, "png", fileToSave);
                    JOptionPane.showMessageDialog(this, "Image saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Error saving image: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Inner class for the drawing area
        class DrawArea extends JPanel {

            private Image image;
            private Graphics2D g2;
            private int prevX, prevY;
            private boolean dragging;
            private Color currentColor = Color.BLACK;

            public DrawArea() {
                setDoubleBuffered(false);
                setBackground(Color.WHITE);
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        prevX = e.getX();
                        prevY = e.getY();
                        dragging = true;
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        dragging = false;
                    }
                });

                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        if (dragging) {
                            int currentX = e.getX();
                            int currentY = e.getY();
                            if (g2 != null) {
                                g2.setColor(currentColor);
                                g2.setStroke(new BasicStroke(2));
                                g2.drawLine(prevX, prevY, currentX, currentY);
                                repaint();
                                prevX = currentX;
                                prevY = currentY;
                            }
                        }
                    }
                });
            }

            public void setCurrentColor(Color color) {
                this.currentColor = color;
            }

            protected void paintComponent(Graphics g) {
                if (image == null) {
                    // Initialize the image
                    image = createImage(getSize().width, getSize().height);
                    g2 = (Graphics2D) image.getGraphics();
                    // Enable anti-aliasing for smoother lines
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    clear();
                }
                g.drawImage(image, 0, 0, null);
            }

            // Clears the drawing area
            public void clear() {
                if (g2 != null) {
                    g2.setPaint(Color.WHITE);
                    g2.fillRect(0, 0, getSize().width, getSize().height);
                    g2.setPaint(currentColor);
                    repaint();
                }
            }

            // Returns the current image
            public BufferedImage getImage() {
                if (image instanceof BufferedImage) {
                    return (BufferedImage) image;
                } else {
                    // Create a buffered image from the current image
                    BufferedImage bufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                    Graphics2D bGr = bufferedImage.createGraphics();
                    bGr.drawImage(image, 0, 0, null);
                    bGr.dispose();
                    return bufferedImage;
                }
            }
        }

        public static void main(String[] args) {
            // Run the GUI in the Event Dispatch Thread
            SwingUtilities.invokeLater(() -> {
                BasicDrawingApp app = new BasicDrawingApp();
                app.setVisible(true);
            });
        }
    }


