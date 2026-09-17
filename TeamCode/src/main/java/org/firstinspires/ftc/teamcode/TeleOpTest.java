package org.firstinspires.ftc.teamcode;

import java.util.ArrayList;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.ExampleSubsystem;

@TeleOp(name = "TeleOp", group = "Linear OpMode")
public class TeleOpTest extends LinearOpMode {
    private InputHandler inputHandler = new InputHandler(telemetry);
    private SubsystemManager subsystemManager;
    private Robot robot = new Robot(hardwareMap);

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
        ArrayList<Subsystem> subs = new ArrayList<>();
        subs.add(new ExampleSubsystem());
        subsystemManager = new SubsystemManager(subs, telemetry, inputHandler, robot);
        subsystemManager.initSubsystems();

        telemetry.addLine("Initializing...");
        Actions.assignActions(inputHandler);
        telemetry.update();
    }

    private void update() {
        telemetry.addLine("Updating...");
        inputHandler.update(gamepad1, gamepad2);
        if (inputHandler.actionHappened("Test Action")) {
            telemetry.addLine("Action Happened!");
        }
        telemetry.update();

        subsystemManager.updateSubsystems();
    }

    private void end() {
        telemetry.addLine("Ending...");
        telemetry.update();

        subsystemManager.terminateSubsystems();
    }
}
