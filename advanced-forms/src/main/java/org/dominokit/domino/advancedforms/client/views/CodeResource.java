package org.dominokit.domino.advancedforms.client.views;

public class CodeResource {

    public static String uploadExample(){
        return "FileUpload fileUpload = FileUpload.create()\n" +
                "        .setIcon(Icons.ALL.touch_app())\n" +
                "        .setUrl(\"http://localhost:8080/form\")\n" +
                "        .multipleFiles()\n" +
                "        .accept(\"image/*\")\n" +
                "        .appendChild(Elements.h(3).textContent(\"Drop files here or click to upload.\").asElement())\n" +
                "        .appendChild(Elements.em().textContent(\"(This is just a demo upload. Selected files are not actually uploaded)\").asElement())\n" +
                "        .onAddFile(fileItem -> {\n" +
                "            fileItem.addErrorHandler(request -> {\n" +
                "                Notification.createDanger(\"Error while uploading \" + request.responseText).show();\n" +
                "            });\n" +
                "            fileItem.addSuccessUploadHandler(request -> {\n" +
                "                Notification.createSuccess(\"File uploaded successfully\").show();\n" +
                "            });\n" +
                "            fileItem.addRemoveHandler(file -> {\n" +
                "                Notification.createInfo(\"File has been removed \" + file.name).show();\n" +
                "            });\n" +
                "        });\n" +
                "\n" +
                "uploadCard.appendContent(fileUpload.asElement());";
    }
}
