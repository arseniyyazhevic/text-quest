package com.syaprojects.adventuretextquest.servlets;
import com.syaprojects.adventuretextquest.service.GameLogic;
import com.syaprojects.adventuretextquest.service.Parameter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/play")
public class GameServlet extends HttpServlet {
    public static int counter = 1;
    public static boolean isFirst = false;
    public static boolean isHit = false;
    public static boolean isBlow = false;
    public static boolean isWatch = false;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        String baseValue = "name";
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("name", "Player");
        try {
            Parameter parameter = null;
            if(counter == 1){
                parameter = GameLogic.connectToFile(1, "data/images/" + 1 + ".png");
                parameter.setText("Один  безумный ученый придумал зелье, которое должно было сделать из человека суперсолдата. Но что-то пошло не по плану и испытуемый превратился в зомби. Вы как командующий 101-ого пехотного полка должны предотвротить нашествие зомби. По данным разведки все зомби находяться в здании лаборатории. Удачи на миссии кэп!");
                setAttributes(req, parameter);
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            if(counter == 2){
                parameter = GameLogic.connectToFile(2, "data/images/" + 2 + ".png");
                parameter.setText("Вы заходите в здание и делетесь на две группы. Вы выбирите первую группу?");
                setAttributes(req, parameter);
                getServletContext().getRequestDispatcher("/choice.jsp").forward(req, resp);
            }
            if (counter == 3) {
                isFirst = Boolean.valueOf(req.getParameter("id"));
                if (isFirst) {
                    parameter = GameLogic.connectToFile(3, "data/images/" + 11 + ".png");
                    parameter.setText("Вы отправляетесь в левую часть здания и слышите шум за дверью. Вы открываете её и видите жуткого зомби. Попытаться убить его с пистолета?");
                } else {
                    parameter = GameLogic.connectToFile(6, "data/images/" + 6 + ".png");
                    parameter.setText("Вы выдвинулись со втрой группой прошли половину здания и не нашли никаких зомби. Вам дали новое задание забрать все шприцы с сывороткой суперчеловека. Вы подходите к шкафу и видите, что-то мигающее. Посмотреть, что там мигает?");
                }
                setAttributes(req, parameter);
                getServletContext().getRequestDispatcher("/choice.jsp").forward(req, resp);
            }
            if (counter == 4) {
                if (isFirst) {
                    isHit = Boolean.valueOf(req.getParameter("id"));
                    if (isHit) {
                        parameter = GameLogic.connectToFile(7, "data/images/поражение.png");
                        parameter.setText("Вы достаёте свой пистолет, стреляете в зомби, но пулями его не возьмёшь. Он атакует вас и убивает. Для вас эта миссия оказалась последняя.");
                        setAttributes(req, parameter);
                        getServletContext().getRequestDispatcher("/end.jsp").forward(req, resp);
                        counter = -1;
                    } else {
                        parameter = GameLogic.connectToFile(4, "data/images/4.png");
                        parameter.setText("Вы видите канистру с бензином. Попытаться взорвать зомби?");
                        setAttributes(req, parameter);
                        getServletContext().getRequestDispatcher("/choice.jsp").forward(req, resp);
                    }
                } else {
                    isWatch = Boolean.valueOf(req.getParameter("id"));
                    if (isWatch) {
                        parameter = GameLogic.connectToFile(8, "data/images/победа.png");
                        parameter.setText("Вы внимательно пригляделись к красному мирцанию и были правы это была бомба, и, что бы ее диактивировать нужно было ввести пароль. Вы узнали пароль и забрали всю сыворотку. Отличная работа капитан!");
                    } else {
                        parameter = GameLogic.connectToFile(9, "data/images/поражение.png");
                        parameter.setText("Вы не обратили внимание на раздражающие мирцание. Попытались открыть шкаф и взорвались. Сегодня точно не ваш день...");
                    }
                    counter = -1;
                    setAttributes(req, parameter);
                    getServletContext().getRequestDispatcher("/end.jsp").forward(req, resp);
                }
            }
            if (counter == 5) {
                isBlow = Boolean.valueOf(req.getParameter("id"));
                if (isBlow) {
                    parameter = GameLogic.connectToFile(5, "data/images/5.png");
                    parameter.setText("Вы убиваете зомби и очищаете здание. Хорошая работа капитан!");
                } else {
                    parameter = GameLogic.connectToFile(10, "data/images/поражение.png");
                    parameter.setText("Вы пытаетесь придумать план нападения на зомби, но он не собирается вас ждать и внезапно атакует. Вы не уклонились от атаки и умерли.");
                }
                counter = -1;
                setAttributes(req, parameter);
                getServletContext().getRequestDispatcher("/end.jsp").forward(req, resp);
            }
            if(counter == 0){
                getServletContext().getRequestDispatcher("/hello.jsp").forward(req, resp);
            }
            counter++;
        }catch (Exception e){
            getServletContext().getRequestDispatcher("/exception.jsp");
        }
    }

    public void setAttributes(HttpServletRequest req, Parameter parameter){
        req.setAttribute("text", parameter.getText());
        req.setAttribute("image", parameter.getPathImg());
    }
}