public class Signleton
{
    public static void main(String[] args)
    {
        System.out.println("hello world\n");

        RollerCoaster rollerCoaster = RollerCoaster.getInstance();

        rollerCoaster.run();

        rollerCoaster.stop();
    }
}

class RollerCoaster
{
    private static RollerCoaster instanceRollerCoaster;
    private Boolean safeGuard;  // 啟用安全裝置！
    private Boolean facilltyState;  // 設備運行狀態

    private RollerCoaster()
    {
        safeGuard = false;  // 安全裝置解除，可以讓乘客上座與離座
        facilltyState = false;  // 運行狀態為停止(False)
    }

    // On Single thread
    public static RollerCoaster getInstance()
    {
        if (instanceRollerCoaster == null)
        {
            instanceRollerCoaster = new RollerCoaster();
        }

        return instanceRollerCoaster;
    }

    // On Multi-Thread
    // public static RollerCoaster getInstanceMultiThread()
    // {
    //     if (instanceRollerCoaster == null)
    //     {
    //         synchronized(RollerCoaster.class)
    //         {
    //             if (instanceRollerCoaster == null)
    //             {
    //                 instanceRollerCoaster = new RollerCoaster();
    //             }
    //         }
    //     }

//        return instanceRollerCoaster;
//    }

    public void run()
    {
        // 執行的時候，必須檢查安全裝置是不是啟用
        // 若沒有啟用，就必須啟用，才能執行設施
        if (!isGuarded())
        {
            safeGuard = true;
            facilltyState = true;
        }
    }

    public void stop()
    {
        // 在停止的時候，必須確認設施正在執行，而且安全設備是啟用的
        if (isRunning() && isGuarded())
        {
            facilltyState = false;
            safeGuard = false;
        }
    }

    public Boolean isRunning()
    {
        return facilltyState;
    }

    public Boolean isGuarded()
    {
        return safeGuard;
    }
}