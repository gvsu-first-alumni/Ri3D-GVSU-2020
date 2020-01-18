package frc.fangv.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.fangv.robot.Constants;

public class HookAndWinchSubsystem implements Subsystem {

// Any variables/fields used in the constructor must appear before the "INSTANCE" variable
// so that they are initialized before the constructor is called.
    CANSparkMax winchMotor;
    Solenoid hookSolenoid;

    /**
     * The Singleton instance of this HookAndWinchSubsystem. External classes should
     * use the {@link #getInstance()} method to get the instance.
     */
    private final static HookAndWinchSubsystem INSTANCE = new HookAndWinchSubsystem();

    /**
     * Creates a new instance of this HookAndWinchSubsystem.
     * This constructor is private since this class is a Singleton. External classes
     * should use the {@link #getInstance()} method to get the instance.
     */
    private HookAndWinchSubsystem() {
        hookSolenoid = new Solenoid(Constants.HOOK_CHANNEL);
        winchMotor = new CANSparkMax(Constants.WINCH_CHANNEL, CANSparkMax.MotorType.kBrushless);
    }

    /**
     * Returns the Singleton instance of this HookAndWinchSubsystem. This static method
     * should be used -- {@code HookAndWinchSubsystem.getInstance();} -- by external
     * classes, rather than the constructor to get the instance of this class.
     */
    public static HookAndWinchSubsystem getInstance() {
        return INSTANCE;
    }

    /** Solenoid Fire */
    public void fire(){ hookSolenoid.set(true); }

    /** Solenoid isFired */
    public boolean isFired(){ return hookSolenoid.get(); }

    /** Solenoid Release */
    public void release(){ hookSolenoid.set(false);}

    /** Winch Motor Forward */
    public void forward(){ winchMotor.set(-Constants.WINCHMOTORSPEEDFORWARD);}

    /** Winch Motor Backward */
    public void backward(){ winchMotor.set(-Constants.WINCHMOTORSPEEDBACKWARD);}

    /** Winch Motor Stop */
    public void stop(){ winchMotor.set(Constants.WINCHMOTORSTOP);}

}

