import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private String currentOperator;
    private double firstOperand;


    public Calculator() {
        setTitle("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField("0");
        displayField.setEditable(false);
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        displayField.setFont(new Font("Aral", Font.BOLD, 24));
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));
        String[] buttonLabels = {
                "1", "2", "3", "+",
                "4", "5", "6", "-",
                "7", "8", "9", "/",
                "C", "0", "x", "=",
                "CE", "Backspace", ".", ""
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("0123456789.".contains(command)) {
            // 숫자 버튼 클릭 시 처리
            if (displayField.getText().equals("0")) {
                displayField.setText(command);
            } else {
                displayField.setText(displayField.getText() + command);
            }
        } else if ("+-x/".contains(command)) {
            // 연산자 버튼 클릭 시 처리
            firstOperand = Double.parseDouble(displayField.getText());
            currentOperator = command.replace("x", "*");
            displayField.setText("0");
        } else if ("=".equals(command)) {
            // 결과 계산
            double secondOperand = Double.parseDouble(displayField.getText());
            double result = 0;

            switch (currentOperator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "x":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        JOptionPane.showMessageDialog(this, "Cannot divide by zero.");
                        return;
                    }
                    break;
            }
            displayField.setText(String.valueOf(result));
            currentOperator = null;
        }
    }

    public static void main(String[] args) {

        new Calculator();
    }

}
