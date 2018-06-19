package org.dominokit.domino.waves.client.views;

public class CodeResource {

    public static String waves() {
        return "//Elements extending WaveElement will have waves by default\n" +
                "//to add Waves to elements that does not extend from WaveElement use the WaveSupport class\n" +
                "\n" +
                "WavesSupport.addFor(element)\n" +
                "    .setWavesColor(WaveColor.YELLOW)\n" +
                "    .applyWaveStyle(WaveStyle.CIRCLE);";
    }
}
