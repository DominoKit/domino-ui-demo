package org.dominokit.domino.animation.client.views;

public class CodeResource{

    public static String animation(){
        return "// Create an animation for the element and pass the transition type and other parameters \n" +
                "Animation.create(element)\n" +
                "        .transition(Transition.BOUNCE)\n" +
                "        .duration(1000)\n" +
                "        .animate();\n" +
                "\n" +
                "// Delay animation start\n" +
                "Animation.create(element)\n" +
                "        .transition(Transition.FLASH)\n" +
                "        .duration(1000)\n" +
                "        .delay(1000)\n" +
                "        .animate();\n" +
                "\n" +
                "// Make the animation infinite\n" +
                "Animation.create(element)\n" +
                "        .transition(Transition.FLIP)\n" +
                "        .duration(1000)\n" +
                "        .infinite()\n" +
                "        .animate();\n" +
                "\n" +
                "// Stop the infinite animation\n" +
                "Animation animation = Animation.create(element)\n" +
                "        .transition(Transition.TADA)\n" +
                "        .duration(1000)\n" +
                "        .infinite()\n" +
                "        .animate();\n" +
                "\n" +
                "animation.stop();";
    }
}

