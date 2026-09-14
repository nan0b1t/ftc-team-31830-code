package org.firstinspires.ftc.teamcode;

import java.util.HashMap;
import java.util.Map;

import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class InputHandler {
    public Map<String, InputAction> actions = new HashMap<>();

    private Gamepad currentGamePad1 = new Gamepad();
    private Gamepad previousGamePad1 = new Gamepad();

    private Gamepad currentGamePad2 = new Gamepad();
    private Gamepad previousGamePad2 = new Gamepad();

    private Telemetry telemetry;

    public InputHandler(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public void update(Gamepad gamepad1, Gamepad gamepad2) {
        previousGamePad1.copy(currentGamePad1);
        previousGamePad2.copy(currentGamePad2);

        currentGamePad1.copy(gamepad1);
        currentGamePad2.copy(gamepad2);
    }

    public void registerAction(String name, InputAction action) {
        actions.put(name, action);
    }

    public boolean actionHappened(String name) {
        InputAction res = actions.get(name);
        if (res != null) {
            switch (res.inputType) {
                case IS_PRESSED:
                    if (isButtonPressed(res.input, res.gamepad)) {
                        return true;
                    }
                    break;
                case WAS_PRESSED:
                    if (wasButtonPressed(res.input, res.gamepad)) {
                        return true;
                    }
                    break;
                case WAS_RELEASED:
                    if (wasButtonReleased(res.input, res.gamepad)) {
                        return true;
                    }
                default:
                    return false;
            }
        }

        telemetry.addLine("ERROR: ATTEMPTED TO ACCESS A NONEXISTENT ACTION");
        return false;
    }

    public enum Button {
        X,
        Y,
        A,
        B,
        LEFT_BUMPER,
        RIGHT_BUMPER,
        DPAD_LEFT,
        DPAD_RIGHT,
        DPAD_UP,
        DPAD_DOWN;
    }

    public enum GamepadNum {
        ONE,
        TWO
    }

    private boolean isButtonPressed(Button b, GamepadNum g) {
        Gamepad locGamePad = (g == GamepadNum.ONE) ? currentGamePad1 : currentGamePad2;

        switch (b) {
            case X:
                return locGamePad.x;
            case Y:
                return locGamePad.y;
            case A:
                return locGamePad.a;
            case B:
                return locGamePad.b;
            case LEFT_BUMPER:
                return locGamePad.left_bumper;
            case RIGHT_BUMPER:
                return locGamePad.right_bumper;
            case DPAD_UP:
                return locGamePad.dpad_up;
            case DPAD_DOWN:
                return locGamePad.dpad_down;
            case DPAD_LEFT:
                return locGamePad.dpad_left;
            case DPAD_RIGHT:
                return locGamePad.dpad_right;
            default:
                return false;
        }
    }

    private boolean wasButtonPressed(Button b, GamepadNum g) {
        Gamepad locGamePad = (g == GamepadNum.ONE) ? currentGamePad1 : currentGamePad2;
        Gamepad oldLocGamePad = (g == GamepadNum.ONE) ? previousGamePad1 : previousGamePad2;

        switch (b) {
            case X:
                return locGamePad.x && !oldLocGamePad.x;
            case Y:
                return locGamePad.y && !oldLocGamePad.y;
            case A:
                return locGamePad.a && !oldLocGamePad.a;
            case B:
                return locGamePad.b && !oldLocGamePad.b;
            case LEFT_BUMPER:
                return locGamePad.left_bumper && !oldLocGamePad.left_bumper;
            case RIGHT_BUMPER:
                return locGamePad.right_bumper && !oldLocGamePad.right_bumper;
            case DPAD_UP:
                return locGamePad.dpad_up && !oldLocGamePad.dpad_up;
            case DPAD_DOWN:
                return locGamePad.dpad_down && !oldLocGamePad.dpad_down;
            case DPAD_LEFT:
                return locGamePad.dpad_left && !oldLocGamePad.dpad_left;
            case DPAD_RIGHT:
                return locGamePad.dpad_right && !oldLocGamePad.dpad_right;
            default:
                return false;
        }
    }

    private boolean wasButtonReleased(Button b, GamepadNum g) {
        Gamepad locGamePad = (g == GamepadNum.ONE) ? currentGamePad1 : currentGamePad2;
        Gamepad oldLocGamePad = (g == GamepadNum.ONE) ? previousGamePad1 : previousGamePad2;

        switch (b) {
            case X:
                return !locGamePad.x && oldLocGamePad.x;
            case Y:
                return !locGamePad.y && oldLocGamePad.y;
            case A:
                return !locGamePad.a && oldLocGamePad.a;
            case B:
                return !locGamePad.b && oldLocGamePad.b;
            case LEFT_BUMPER:
                return !locGamePad.left_bumper && oldLocGamePad.left_bumper;
            case RIGHT_BUMPER:
                return !locGamePad.right_bumper && oldLocGamePad.right_bumper;
            case DPAD_UP:
                return !locGamePad.dpad_up && oldLocGamePad.dpad_up;
            case DPAD_DOWN:
                return !locGamePad.dpad_down && oldLocGamePad.dpad_down;
            case DPAD_LEFT:
                return !locGamePad.dpad_left && oldLocGamePad.dpad_left;
            case DPAD_RIGHT:
                return !locGamePad.dpad_right && oldLocGamePad.dpad_right;
            default:
                return false;
        }
    }
}
