package frc.fangv.robot;

import edu.wpi.first.wpilibj.Timer;

public class FangvPIDController
{
    private final double kIAccumLimit = 100.0;

    private double lastTime = -1;

    private double upperOutputLimit;
    private double lowerOutputLimit;

    private double kP;
    private double kI;
    private double kD;
    private double kFF;

    private double iAccum;

    public FangvPIDController(
            double upperOutputLimit, double lowerOutputLimit,
            double kp, double ki, double kd, double kff) {
        this.kP = kp;
        this.kI = ki;
        this.kD = kd;
        this.kFF = kff;
        this.upperOutputLimit = upperOutputLimit;
        this.lowerOutputLimit = lowerOutputLimit;
    }

    public void setOutput(double outputUpper, double outputLower) {
        this.upperOutputLimit = outputUpper;
        this.lowerOutputLimit = outputLower;
    }

    public void setPIDF(double kp, double ki, double kd, double kff) {
        this.kP = kp;
        this.kI = ki;
        this.kD = kd;
        this.kFF = kff;
    }

    public double process(double setpoint, double input) {
        if (lastTime < 0) {
            lastTime = Timer.getFPGATimestamp();
            return 0;
        }
        double dt = Timer.getFPGATimestamp() - lastTime;
        double error = setpoint - input;

        // P component
        double p = kP * error;

        // I Component
        iAccum += error * dt;
        if (iAccum > kIAccumLimit) iAccum = kIAccumLimit;
        if (iAccum < -kIAccumLimit) iAccum = -kIAccumLimit;

        double i = kI * iAccum;

        // D component
        double d = kD * error / dt;

        // "Ideal" PID Algorithm with velocity damping
        double ret = p + i - d;
        if (ret > upperOutputLimit) return upperOutputLimit;
        if (ret < lowerOutputLimit) return lowerOutputLimit;
        else return ret;
    }
}
