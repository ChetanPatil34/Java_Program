
    import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.Stack;

    public class DrawingApp extends JFrame {
        private DrawArea drawArea;
        private Color currentColor = Color.BLACK;
        private JButton clearBtn, colorBtn, undoBtn, redoBtn, saveBtn;

        // Stack to keep track of actions for undo/redo functionality
        private Stack<BufferedImage> undoStack = new Stack<>();
        private Stack<BufferedImage> redoStack = new Stack<>();

        public DrawingApp() {
            // Set up the main window
            setTitle("Basic Drawing Application");
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create drawing area
            drawArea = new DrawArea();
            add(drawArea, BorderLayout.CENTER);

            // Create control panel
            JPanel controlPanel = new JPanel();

            // Clear Button
            clearBtn = new JButton("Clear");
            clearBtn.addActionListener(e -> {
                drawArea.clear();
            });
            controlPanel.add(clearBtn);

            // Color Button
            colorBtn = new JButton("Choose Color");
            colorBtn.addActionListener(e -> {
                Color newColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
                if (newColor != null) {
                    currentColor = newColor;
                    drawArea.setCurrentColor(currentColor);
                }
            });
            controlPanel.add(colorBtn);

            // Undo Button
            undoBtn = new JButton("Undo");
            undoBtn.addActionListener(e -> {
                drawArea.undo();
            });
            controlPanel.add(undoBtn);

            // Redo Button
            redoBtn = new JButton("Redo");
            redoBtn.addActionListener(e -> {
                drawArea.redo();
            });
            controlPanel.add(redoBtn);

            // Save Button
            saveBtn = new JButton("Save");
            saveBtn.addActionListener(e -> {
                drawArea.saveImage();
            });
            controlPanel.add(saveBtn);

            // Add control panel to the frame
            add(controlPanel, BorderLayout.NORTH);

            setVisible(true);
        }

        // Drawing Area Panel
        class DrawArea extends JPanel {
            private BufferedImage image;
            private Graphics2D g2;
            private int prevX, prevY;

            public DrawArea() {
                setPreferredSize(new Dimension(800, 600));
                setBackground(Color.WHITE);
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        saveToUndoStack();
                        prevX = e.getX();
                        prevY = e.getY();
                    }
                });

                addMouseMotionListener(new MouseMotionAdapter() {
                    @Override
                    public void mouseDragged(MouseEvent e) {
                        int x = e.getX();
                        int y = e.getY();
                        if (g2 != null) {
                            g2.setColor(currentColor);
                            g2.drawLine(prevX, prevY, x, y);
                            repaint();
                            prevX = x;
                            prevY = y;
                        }
                    }
                });

                createEmptyImage();
            }

            // Method to create an empty canvas
            private void createEmptyImage() {
                image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
                g2 = (Graphics2D) image.getGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE);
                g2.fillRect(0, 0, 800, 600);
            }

            // Override paintComponent to draw the image
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }

            // Clear the drawing area
            public void clear() {
                createEmptyImage();
                repaint();
            }

            // Set current color
            public void setCurrentColor(Color color) {
                currentColor = color;
            }

            // Save image to undo stack
            private void saveToUndoStack() {
                BufferedImage copy = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
                Graphics gCopy = copy.createGraphics();
                gCopy.drawImage(image, 0, 0, null);
                gCopy.dispose();
                undoStack.push(copy);
                redoStack.clear(); // Clear redo stack on new action
            }

            // Undo last action
            public void undo() {
                if (!undoStack.isEmpty()) {
                    redoStack.push(image);
                    image = undoStack.pop();
                    g2 = (Graphics2D) image.getGraphics();
                    repaint();
                }
            }

            // Redo last undone action
            public void redo() {
                if (!redoStack.isEmpty()) {
                    undoStack.push(image);
                    image = redoStack.pop();
                    g2 = (Graphics2D) image.getGraphics();
                    repaint();
                }
            }

            // Save the image to a file
            public void saveImage() {
                try {
                    File outputfile = new File("drawing.png");
                    ImageIO.write(image, "png", outputfile);
                    JOptionPane.showMessageDialog(null, "Image saved!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public static void main(String[] args) {
            new DrawingApp();
        }
    }


