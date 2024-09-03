package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class Drive extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {


        // Hardware Map
        DcMotor FL = hardwareMap.dcMotor.get("FL");
        DcMotor BL = hardwareMap.dcMotor.get("BL");
        DcMotor FR = hardwareMap.dcMotor.get("FR");
        DcMotor BR = hardwareMap.dcMotor.get("BR");
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
        FR.setDirection(DcMotorSimple.Direction.FORWARD);
        BR.setDirection(DcMotorSimple.Direction.FORWARD);
        FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
             double Drivevar; {
                 double speed = 1;
                 double ly = -gamepad1.left_stick_y * speed;
                 double lx = gamepad1.left_stick_x * 1.1 * speed;
                 double rx = gamepad1.right_stick_x * speed;

                 double Correction = Math.max(Math.abs(ly) + Math.abs(lx) + Math.abs(rx), 1);
                 double frontLeftPower = (ly + lx + rx) / Correction;
                 double backLeftPower = (ly - lx + rx) / Correction;
                 double frontRightPower = (ly - lx - rx) / Correction;
                 double backRightPower = (ly + lx - rx) / Correction;

            FL.setPower(frontLeftPower);
            BL.setPower(backLeftPower);
            FR.setPower(frontRightPower);
            BR.setPower(backRightPower);
             }
            telemetry.update();
        }
    }
}
