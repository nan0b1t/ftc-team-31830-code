package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "TeleOp", group = "Linear OpMode")
public class TeleOpTest extends LinearOpMode {
    private InputHandler inputHandler = new InputHandler(telemetry);

    @Override
    public void runOpMode() {
        initialize();

        waitForStart();
        while (opModeIsActive()) {
            update();
            telemetry.update();
        }

        end();
    }

    private void initialize() {
        telemetry.addLine("Initializing...");
        telemetry.update();
    }

    private void update() {
        telemetry.addLine("Updating...");
        inputHandler.update(gamepad1, gamepad2);
        telemetry.update();
    }

    private void end() {
        telemetry.addLine("Ending...");
        telemetry.update();
    }
}
