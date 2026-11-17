package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Robot {
     RobotHardware hardware;

     public Robot(HardwareMap hw) {
        hardware = new RobotHardware(hw);
     }

     public void runDriveTrain(DriveValues vals) {
         hardware.leftDriveFront.setPower(vals.FL);
         hardware.rightDriveFront.setPower(vals.FR);
         hardware.leftDriveBack.setPower(vals.BL);
         hardware.rightDriveBack.setPower(vals.BR);
     }

     public void endDriveTrain() {
         hardware.leftDriveFront.setPower(0);
         hardware.rightDriveFront.setPower(0);
         hardware.leftDriveBack.setPower(0);
         hardware.rightDriveBack.setPower(0);
     }

     public void runIntake() {
        hardware.intake.setPower(1);
        hardware.rightIntakeServo.setPower(-1);
        hardware.leftIntakeServo.setPower(-1);
     }

     public void stopIntake() {
        hardware.intake.setPower(0);
        hardware.rightIntakeServo.setPower(0);
        hardware.leftIntakeServo.setPower(0);
     }

     public void revLauncher(double velocity) {
        hardware.launcher.setVelocity(velocity);
     }

     public void startWindmill() {
         hardware.windmillServo.setPower(-1.0);
     }

     public void stopWindmill() {
         hardware.windmillServo.setPower(0.0);
     }

     public void stopLauncher() {
        hardware.launcher.setVelocity(0);
        hardware.windmillServo.setPower(0.0);
     }

     public double getLauncherVelocity() {
        return hardware.launcher.getVelocity();
     }

     public double getRotationDegrees() {
        return hardware.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
     }

     public void setTargetRotation(Integer i) {}
}
