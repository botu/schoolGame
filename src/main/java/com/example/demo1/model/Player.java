package com.example.demo1.model;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;

import java.util.HashSet;

/**
 * Класс-декоратор для персонажа
 */
public class Player {

    /**
     * Величина перемещения вверх/вниз за единицу времени
     */
    private static final double STEP_UP = 1d;

    /**
     * Величина перемещения влево/вправо за единици времени
     */
    private static final double STEP_X = 1d;

    /**
     * Геометрическая фигура персонажа (в дальнейшем надо заменить напримре на canvas)
     */
    private final Circle circle;


    /**
     * текущик состояния движения. Если отсутствует - персонаж не двигается
     */
    HashSet<MoveEnum> direction = new HashSet<>();


    /**
     * Установка состояния движения
     * @param direction состояние/направление движения
     */
    public void setDirection(MoveEnum direction)
    {
        deleteCollision(direction);
        this.direction.add(direction);
    }


    /**
     * Убираем коллизии (противоречия) состояний движения
     * @param direction напрвление которое пытаемся сейчас добавить
     */
    private void deleteCollision(MoveEnum direction) {
        switch (direction)
        {
            case LEFT:
                this.direction.remove(direction);
                break;
            case RIGHT:
                this.direction.remove(direction);
                break;
            case UP:
                this.direction.remove(direction);
                break;
            case DOWN:
                this.direction.remove(direction);
                break;
        }
    }


    /**
     * Конструктор
     * @param x координаты по Х
     * @param y координаты по У
     * @param radius диаметр игрока (или максимальный размер персонажа)
     */
    public Player(double x, double y, double radius) {
        circle = new Circle(x,y,radius);
    }

    /**
     * добавление игрока на сцену
     * @param group сцена на которую будет добавлен персонаж
     */
    public void addToStage(Group group){
        group.getChildren().add(circle);
    }


    /**
     * тестовая инициализация движени
     * ToDo: Вдальнешем данный метод необходимо удилть
     */
    public void testMove(){
        direction.add(MoveEnum.UP);
        direction.add(MoveEnum.RIGHT);

    }

    /**
     * Движение персонажа
     */
    public void move(){
        direction.stream().forEach(
                (element)->{
                    switch (element)
                    {
                        case UP:
                            circle.setCenterY(circle.getCenterY()-STEP_UP);
                            //ToDo сделать границу сверху - гравитация
                            break;
                        case DOWN:
                            circle.setCenterY(circle.getCenterY()+STEP_UP);
                            break;
                        case LEFT:
                            circle.setCenterX(circle.getCenterX()-STEP_X);

                        case RIGHT:
                            circle.setCenterX(circle.getCenterX()+STEP_X);
                    }
                }
        );

    }


}
