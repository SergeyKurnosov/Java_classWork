package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {


        //============================================================================
        /*
        1.Окно JFrame с кнопкой «Сгенерировать», полем для вывода и двумя полями ввода: «от» и «до».
        По нажатию на кнопку в метку выводится случайное число из этого диапазона.
        Если в поля введено не число или «от» больше «до», вывести сообщение об ошибке в ту же метку.
         */
        JTextField jTextField_min = new JTextField(5), jTextField_max = new JTextField(5);
        JLabel jLabel_min = new JLabel("min"),jLabel_max = new JLabel("max"),jLabel_result = new JLabel("___");
        JPanel jPanel = new JPanel(new GridLayout(4,2,8,8));
        JButton jButton = new JButton("Сгенерировать");
        jButton.addActionListener(e->{
            String value1 = jTextField_min.getText() , value2 = jTextField_max.getText();
            int min = 0,max=0;
            if (value1 != null && !value1.isEmpty() && value2 != null && !value2.isEmpty()) {
                try {
                    min = Integer.parseInt(value1);
                    max = Integer.parseInt(value2);
                    if(min > max){
                        jLabel_result.setText("min не может быть больше max (исправлено)");
                        jTextField_min.setText(String.valueOf(max));
                        jTextField_max.setText(String.valueOf(min));
                    }
                    else {
                        if(min == max)
                            jLabel_result.setText(String.valueOf(min));
                        else
                            jLabel_result.setText(String.valueOf((int) (Math.random() * (max - min + 1)) + min));
                    }
                }catch (NumberFormatException ex) {
                    return;
                }
            }

        });
        JFrame jFrame1 = new JFrame("Task1");
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel.add(jLabel_min);
        jPanel.add(jTextField_min);
        jPanel.add(jLabel_max);
        jPanel.add(jTextField_max);
        jPanel.add(jButton);
        jPanel.add(jLabel_result);
        jFrame1.add(jPanel);
        jFrame1.setSize(400,200);

        jFrame1.setLocationRelativeTo(null);
        jFrame1.setVisible(true);


        //============================================================================
        /*
        2.Окно с кнопкой «Клик» и меткой «Кликов: 0». Каждый клик увеличивает счётчик.
        Добавь кнопку «Сброс», а когда счётчик дойдёт до 10, пусть метка меняет текст на «Хватит кликать!».
         */
        JLabel jLabel_result = new JLabel("___");
        JPanel jPanel = new JPanel(new GridLayout(1,2,8,8));
        JButton jButton_click = new JButton("Клик") , jButton_clear = new JButton("Сброс");
        int [] count = {0};
        jButton_click.addActionListener(e->{
            if(++count[0]!=10){
                jLabel_result.setText("Кликов: "+ count[0]);
            }
            else {
                jLabel_result.setText("Хватит кликать!");
                count[0]=0;
            }
        });

        jButton_clear.addActionListener(e->{
            jLabel_result.setText("");
            count[0]=0;
        });
        JFrame jFrame1 = new JFrame("Task2");
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel.add(jButton_click);
        jPanel.add(jButton_clear);
        jPanel.add(jLabel_result);
        jFrame1.add(jPanel);
        jFrame1.setSize(400,200);

        jFrame1.setLocationRelativeTo(null);
        jFrame1.setVisible(true);

        //============================================================================

    }
}
