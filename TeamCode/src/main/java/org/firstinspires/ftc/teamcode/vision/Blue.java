package org.firstinspires.ftc.teamcode.vision;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.opencv.core.Scalar;

@Autonomous
public class Blue extends LinearOpMode {

    private VisionPortal visionPortal;

    private ColourMassDetectionProcessor colourMassDetectionProcessor;

    @Override
    public void runOpMode() {

        Scalar lower = new Scalar(100, 50, 100);
        Scalar upper = new Scalar(190, 255, 255);
        double minArea = 30;
        colourMassDetectionProcessor = new ColourMassDetectionProcessor(
                lower,
                upper,
                () -> minArea,
                () -> 100,
                () -> 426
        );
        visionPortal = new VisionPortal.Builder()
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .addProcessor(colourMassDetectionProcessor)
                .build();

        telemetry.addData("Currently Recorded Position", colourMassDetectionProcessor.getRecordedPropPosition());
        telemetry.addData("Camera State", visionPortal.getCameraState());
        telemetry.addData("Currently Detected Mass Center", "x: " + colourMassDetectionProcessor.getLargestContourX() + ", y: " + colourMassDetectionProcessor.getLargestContourY());
        telemetry.addData("Currently Detected Mass Area", colourMassDetectionProcessor.getLargestContourArea());
        waitForStart();
        if (opModeIsActive()) {
            telemetry.update();

            if (visionPortal.getCameraState() == VisionPortal.CameraState.STREAMING) {
                visionPortal.stopLiveView();
                visionPortal.stopStreaming();
            }


            ColourMassDetectionProcessor.PropPositions recordedPropPosition = colourMassDetectionProcessor.getRecordedPropPosition();


            if (recordedPropPosition == ColourMassDetectionProcessor.PropPositions.UNFOUND) {
                recordedPropPosition = ColourMassDetectionProcessor.PropPositions.LEFT;
            }




            switch (recordedPropPosition) {
                case LEFT:


                    telemetry.addLine("Left");
                    break;
                case UNFOUND:

                    telemetry.addLine("Unfound");
                case MIDDLE:

                    telemetry.addLine("Middle");
                    break;
                case RIGHT:

                    telemetry.addLine("Right");
                    break;
            }
        }
    }
}
