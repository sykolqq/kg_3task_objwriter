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

    public static void saveModel(Model model, String fileName){
        Path path = Path.of("ObjWritter/modelSave/" + fileName + ".obj");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {

            // Записываем вершины
            if(model.vertices.size() > 0){
                writer.write("#VERTEXS");
                writer.newLine();
                writer.newLine();

                for (int i = 0; i < model.vertices.size(); i += 1) {
                    writer.write(OBJ_VERTEX_TOKEN);
                    writer.write(" ");
                    writer.write(String.valueOf(model.vertices.get(i)));
                    writer.newLine();
                }

                writer.newLine();
            }

            // Записываем текстурные координаты
            if(model.textureVertices.size() > 0){
                writer.write("#TEXTURES");
                writer.newLine();
                writer.newLine();

                for (int i = 0; i < model.textureVertices.size(); i += 1) {
                    writer.write(OBJ_TEXTURE_TOKEN);
                    writer.write(" ");
                    writer.write(String.valueOf(model.textureVertices.get(i)));
                    writer.newLine();
                }

                writer.newLine();
            }
            // Записываем нормали
            if(model.normals.size() > 0){
                writer.write("#NORMALS");
                writer.newLine();
                writer.newLine();

                for (int i = 0; i < model.normals.size(); i += 1) {
                    writer.write(OBJ_NORMAL_TOKEN);
                    writer.write(" ");
                    writer.write(String.valueOf(model.normals.get(i)));
                    writer.newLine();
                }

                writer.newLine();
            }

            // Записываем полгиноны
            if(model.polygons.size() > 0){
                writer.write("#FACES");
                writer.newLine();
                writer.newLine();

                for (int i = 0; i < model.polygons.size(); i += 1) {
                    writer.write(OBJ_FACE_TOKEN);
                    writer.write(" ");
                    writer.write(String.valueOf(model.polygons.get(i)));
                    writer.newLine();
                }

                writer.newLine();
            }


            System.out.println("Файл успешно сохранён: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
