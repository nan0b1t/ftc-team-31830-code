package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

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

     public void revLauncher() {
        hardware.launcher.setVelocity(-100);
        hardware.windmillServo.setPower(-1.0);
     }

     public void stopLauncher() {
         hardware.launcher.setVelocity(0);
        hardware.windmillServo.setPower(0.0);
     }

}
