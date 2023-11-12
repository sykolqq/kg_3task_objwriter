package com.cgvsu;

import com.cgvsu.math.Vector2f;
import com.cgvsu.model.Model;
import com.cgvsu.objWritter.ObjWritter;
import com.cgvsu.objreader.ObjReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("ObjWritter/modelObj/cottage_obj.obj");
        String fileContent = Files.readString(fileName);

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());

        ObjWritter.saveModel(model, "test1");

        Vector2f v2 = new Vector2f(-1, 7);
        System.out.println(v2);
    }
}
