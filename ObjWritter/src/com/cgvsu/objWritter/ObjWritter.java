package com.cgvsu.objWritter;

import com.cgvsu.model.Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ObjWritter {

    private static final String OBJ_VERTEX_TOKEN = "v";
    private static final String OBJ_TEXTURE_TOKEN = "vt";
    private static final String OBJ_NORMAL_TOKEN = "vn";
    private static final String OBJ_FACE_TOKEN = "f";

    public void saveModel(Model model, String fileName){
        Path path = Path.of("ObjWritter/modelSave/" + fileName + ".obj");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            // Записываем вершины
            for (int i = 0; i < vertices.length; i += 3) {
                writer.write("v " + vertices[i] + " " + vertices[i + 1] + " " + vertices[i + 2]);
                writer.newLine();
            }

            // Дополнительно, вы можете добавить запись для нормалей, текстурных координат и других данных

            System.out.println("Файл успешно записан: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
