package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {
     RobotHardware hardware;

     public Robot(HardwareMap hw) {
        hardware = new RobotHardware(hw);
     }

     public void startMotor() {
        hardware.leftFrontDrive.setPower(1);
     }

     public void endMotor() {
        hardware.leftFrontDrive.setPower(0);
     }

     public void setServo() {
        hardware.intakeServo.setPosition(0.75);
     }

     public void endServo() {
        hardware.intakeServo.setPosition(0);
     }
}
