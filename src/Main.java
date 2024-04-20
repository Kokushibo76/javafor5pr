import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    private int power_points;
    private int speed_points;
    private int agility_points;
    private String name;
    private java.util.Scanner Scanner;

    public static void main(String[] args) throws FileNotFoundException {
        Main game = new Main();
        game.start();
    }

    public void start() throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        try {
            initializePoints();

            System.out.print("ФИО покойника: ");
            name = console.nextLine();

            System.out.print("Вдруг покойника воскрешает профессор Зомбу");
            ZombieDescription(console);
            System.out.print("\nВыберите тип зомби, каким хотите стать: ");
            System.out.print("\n1.Зомби обычный\n2.Зомби с ведром на голове\n3.Зомби-футболист\n4.Зомби-плавец");

            System.out.print("\nВыбор:");
            int zombu = console.nextInt();
            chooseZombuType(zombu);

            System.out.print("\n" + "Выберите бонус: ");BonusDescription (console);
            System.out.print("\n1.Действие\n2.Скорость\n3.Ловкость");
            System.out.print("\nВыбор: ");
            updatePoints(console);

            System.out.print("\n" + "\nСловно во время высадки в Нормандию ваш зомби отправляется в бой.");
            System.out.print("\nПроходя мимо могил вы выходите к пустующей площадке на которой расположилсь высаженные растения.");
            System.out.print("\nОни расположены отсраненно друг от друга. Чтобы пройти дальше в город вам необходимо уничтожить одно из растений.");
            System.out.print("\nВам предстоит сделать выбор. Какое из растений вы аттакуете первым?");
            selectOpponent(console);

            if (power_points <= 0){
                System.out.print("Game over :(");
            }
            else {
                System.out.print("\nОдолев одно из растений вы продвигаетесь дальше.");
            }

            int bonus = console.nextInt();
            System.out.print("\nВы наступаете на  капкан. Выберите бонус для списания");
            updatePoints(console);

            System.out.print("\nВторое поле быитвы содержит кактусомет, горохострел и подсолнух. Кого атакуете?");
            Select_newOpponent(console);
            System.out.print("\nЗа успешную победу вы получаете дополнительное повышения очков действия/скорости/ловкости");
            Bonus_choice(console);

            System.out.print("\nОдолев противника вы находите выход с кладбища. Ващ зомби направляется в город.");
            points_Result(Scanner);
        } catch (Exception e) {
        }

        System.out.print("\nПроцесс окончен.");
    }

    public void initializePoints() {
        power_points = 0;
        speed_points = 0;
        agility_points = 0;
    }

    public void chooseZombuType(int zombu) {
        switch (zombu) {
            case 1:
                System.out.print("Один из самых худших из зомби. \n+1 очко действия\n");
                power_points += 1;
                break;
            case 2:
                System.out.print("Вы наверное выбирали случайно. \nТем не менее вам начисляется 2 очка действия\n");
                power_points += 2;
                break;
            case 3:
                System.out.print("Отличный выбор! \nВам начисляется 3 очка действия\n");
                power_points += 3;
                break;
            case 4:
                System.out.print("Банально, но это сильный зомби. \n+2 очка действия\n");
                power_points += 4;
                break;
            default:
                System.out.print("Обычный зомби - стандарт для оживших мертвецов. \nИ так, продолжим");
                power_points += 1;
                break;
        }
    }

    public void updatePoints(Scanner console) {
        int bonus = console.nextInt();
        switch (bonus) {
            case 1:
                power_points += 1;
                System.out.print("Очки действия увеличины на 1");
                break;
            case 2:
                speed_points += 1;
                System.out.print("Скорость увеличина на 1");
                break;
            case 3:
                agility_points += 1;
                System.out.print("Ловкость увеличина на 1");
                break;
            default:
                System.out.print("Итак, продолжим");
                break;
        }
    }

    public int selectOpponent(Scanner console) {
        System.out.print("\n1.Бомба-гриб\n2.Гриб-мет\n3.Живой-светильник");
        System.out.print("\nВыбор: ");
        int opponent = console.nextInt();
        switch (opponent) {
            case 1:
                System.out.print("Бомба-гриб взрывается через 3 секунды.");
                if (speed_points == 1) {
                    System.out.print("\nВы успели убежать. Вы теряете только 1 очко действия.");
                    power_points -= 1;
                } else {
                    System.out.print("\nВас задел взрыв. Вы теряете 2 очка действия.");
                    power_points -= 2;
                }
                break;
            case 2:
                System.out.print("Гриб-метатель стреляет по вам 3 раза, после чего вы уничтожаете его.");
                if (agility_points == 1) {
                    System.out.print("\nВам удалось уклониться от его выстрелов из-за своей ловкости. Вы теряете только 1 очко действия.");
                    power_points -= 1;
                } else {
                    System.out.print("\nВсе три снаряда попали по вам. Вы теряете 2 очка действия.");
                    power_points -= 2;
                }
                break;
            case 3:
                System.out.print("\nЖивая лампа не может дать отпор. Без всяких проблем вы уничтожаете ее.");
                power_points -= 1;
                break;
            default:
                System.out.print("И так, продолжим");
                return power_points;
        }
        return power_points;
    }

    public int[] Bonus_choice(Scanner console) {
        int bonus = console.nextInt();
        switch (bonus) {
            case 1:
                power_points += 1;
                System.out.print("Очки действия увеличины на 1");
                break;
            case 2:
                speed_points += 1;
                System.out.print("Скорость увеличина на 1");
                break;
            case 3:
                agility_points += 1;
                System.out.print("Ловкость увеличина на 1");
                break;
            default:
                System.out.print("Итак, продолжим");
                break;
        }
        return new int[]{power_points, speed_points, agility_points};
    }

    public int Select_newOpponent(Scanner console) {
        System.out.print("\n1.Кактусомет\n2.Горохострел\n3.Подсолнух");
        System.out.print("\nВыбор: ");
        int opponent = console.nextInt();
        switch (opponent) {
            case 1:
                System.out.print("Бомба-гриб взрывается через 3 секунды.");
                if (speed_points == 1) {
                    System.out.print("\nВы успели убежать. Вы теряете только 1 очко действия.");
                    power_points -= 1;
                } else {
                    System.out.print("\nВас задел взрыв. Вы теряете 2 очка действия.");
                    power_points -= 2;
                }
                break;
            case 2:
                System.out.print("Горохострел стреляет по вам 3 раза, после чего вы уничтожаете его.");
                if (agility_points == 1) {
                    System.out.print("\nВам удалось уклониться от его выстрелов из-за своей ловкости. Вы теряете только 1 очко действия.");
                    power_points -= 1;
                } else {
                    System.out.print("\nВсе три снаряда попали по вам. Вы теряете 2 очка действия.");
                    power_points -= 2;
                }
                break;
            case 3:
                System.out.print("\nПодсолнух не может дать отпор. Без всяких проблем вы уничтожаете ее.");
                power_points -= 1;
                break;
            default:
                System.out.print("И так, продолжим");

        }
        return power_points;
    }

    public static void ZombieDescription(Scanner console){
        System.out.print("\n1.Зомби обычный - ичем не примечательный зомби\n2.Зомби с ведром на голове - отличается своей бронированностью\n3.Зомби-футболист - в прошлом был спортивным человеком\n4.Зомби-плавец - ничем практически не отличается от зомби-футболиста");
    }

    public static void BonusDescription (Scanner console){
        System.out.print("\n1.Очки действия показывают вашу способность действовать\n2.Скорость - очко скорости позволит вам убежать от взрыва\n3.Ловкость - способность ловко уворачиваться от снарядов");
    }
    public void points_Result(Scanner console){
        System.out.print("\nИгра окончена!\nВаши характеристики:\nФИО зомби: " + name + ", накопленные очки: \n" + "Очки действия - " + power_points);
        System.out.print("\nСкорость - " + speed_points + "\nЛовкость - " + agility_points);
    }
}
