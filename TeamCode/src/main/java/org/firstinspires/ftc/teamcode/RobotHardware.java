package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class RobotHardware {
    public DcMotor leftFrontDrive = null;
    public Servo intakeServo = null;

    public RobotHardware(HardwareMap hardwareMap) {
        leftFrontDrive = hardwareMap.get(DcMotor.class, "left_front");
        intakeServo = hardwareMap.get(Servo.class, "intake_servo");

        leftFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        leftFrontDrive.setPower(0.0);
    }
}
