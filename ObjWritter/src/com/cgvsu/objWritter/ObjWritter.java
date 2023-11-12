package com.cgvsu.objWritter;

import com.cgvsu.model.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class ObjWritter {

    private static final String OBJ_VERTEX_TOKEN = "v";
    private static final String OBJ_TEXTURE_TOKEN = "vt";
    private static final String OBJ_NORMAL_TOKEN = "vn";
    private static final String OBJ_FACE_TOKEN = "f";

    public static void saveModel(Model model, String fileName){
        Path path = Path.of("ObjWritter/modelSave/" + fileName + ".obj");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {

            // Записываем вершины
            writeData(writer, "#VERTEXS", OBJ_VERTEX_TOKEN, model.vertices);
            // Записываем текстурные координаты
            writeData(writer, "#TEXTURES", OBJ_TEXTURE_TOKEN, model.textureVertices);
            // Записываем нормали
            writeData(writer, "#NORMALS", OBJ_NORMAL_TOKEN, model.normals);
            // Записываем полгиноны
            writeData(writer, "#FACES", OBJ_FACE_TOKEN, model.polygons);

            System.out.println("Файл успешно сохранён: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeData(BufferedWriter wr, String comment, String TOKEN, ArrayList data) throws IOException {
        if(data.size() > 0){
            wr.write(comment);
            wr.newLine();
            wr.newLine();

            for (Object datum : data) {
                wr.write(TOKEN);
                wr.write(" ");
                wr.write(String.valueOf(datum));
                wr.newLine();
            }

            wr.newLine();
        }
    }
}
