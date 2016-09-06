import java.awt.event.KeyEvent;

/**
 * Created by Sergey on 05.09.16.
 */
public class Basketball {

    private int width;
    private int height;

    public Basketball(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private Basket basket;
    private Ball ball;
    private Player player;

    private boolean isGameOver = false;


    public static Basketball game;


    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }




    public void setBasket(Basket basket) {
        this.basket = basket;
    }


    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void move() {
        player.move();


        basket.move();
        ball.move();
    }

    public void draw(Canvas canvas) {
        drawBoders(canvas);

        ball.draw(canvas);
        basket.draw(canvas);


    }

    private void drawBoders(Canvas canvas) {
        //draw game
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                canvas.setPoint(i, j, '.');
            }
        }

        for (int i = 0; i < width + 2; i++) {
            canvas.setPoint(i, 0, '-');
            canvas.setPoint(i, height + 1, '-');
        }

        for (int i = 0; i < height + 2; i++) {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(width + 1, i, '|');
        }
    }

    public void checkBallBump() {
        if (ball.isIntersec(basket)) {
            System.out.println("You are hit the basket");
            isGameOver = true;
        }
    }


    public void run() throws Exception {

        Canvas canvas = new Canvas(width, height);

        //Создаем объект "наблюдатель за клавиатурой" и стартуем его.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        //Исполняем цикл, пока игра не окончека
        while (!isGameOver) {

            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();


                if (event.getKeyCode() == KeyEvent.VK_LEFT) {
                    player.moveLeft();
                    player.setPlayerMovedLeft(true);
                    player.setPlayerMovedRight(false);
                } else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
                    player.moveRight();
                    player.setPlayerMovedRight(true);
                    player.setPlayerMovedLeft(false);
                }
                    // if Space start the ball
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ball.start();
            }

            //двигаем все объекты
            move();

            //проверяем столкновения
            // checkBricksBump();
            checkBallBump();

            //проверяем, что шарик мог улететь через дно.
            //checkEndGame();

            //отрисовываем все объекты
            canvas.clear();
            draw(canvas);
            canvas.print();

            //пауза
            Thread.sleep(300);
        }

        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    public static void main(String[] args) throws Exception {
        game = new Basketball(20, 30);

        Ball ball = new Ball(10, 29,2);
        game.setBall(ball);

        Basket basket = new Basket(0, 0, 1, 2);
        game.setBasket(basket);

        Player player = new Player(10, 30);
        game.setPlayer(player);


        game.run();
    }
}
