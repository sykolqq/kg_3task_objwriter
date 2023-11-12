package com.cgvsu.objWritter;

import com.cgvsu.model.Model;
import com.cgvsu.objreader.ObjReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class objWritterTest {
    Path fileName = Path.of("ObjWritter/modelObj/cottage_obj.obj");
    String fileContent = Files.readString(fileName);

    Model model = ObjReader.read(fileContent);

    public objWritterTest() throws IOException {
    }

    @Test
    public void objWritterTestSaveFile01(){
        File fileStart = new File(String.valueOf(Path.of("ObjWritter/modelSave/ae_q_.obj")));
        if(fileStart.exists()){
            fileStart.delete();
        }
        ObjWritter.saveModel(model, "  ae/q.");
        File file = new File(String.valueOf(Path.of("ObjWritter/modelSave/ae_q_.obj")));

        Assertions.assertTrue(file.exists());
    }

    @Test
    public void objWritterTestCountVertex01() throws IOException {
        File fileStart = new File(String.valueOf(Path.of("ObjWritter/modelSave/modelForTest.obj")));
        if(fileStart.exists()){
            fileStart.delete();
        }
        ObjWritter.saveModel(model, " modelForTest");
        String fileContent = Files.readString(Path.of("ObjWritter/modelSave/modelForTest.obj"));
        int count = objWritterTest.count(fileContent, "v ");

        Assertions.assertEquals(count, model.vertices.size());
    }
    @Test
    public void objWritterTestCountTextureVertex01() throws IOException {
        File fileStart = new File(String.valueOf(Path.of("ObjWritter/modelSave/modelForTest.obj")));
        if(fileStart.exists()){
            fileStart.delete();
        }
        ObjWritter.saveModel(model, "modelForTest");
        String fileContent = Files.readString(Path.of("ObjWritter/modelSave/modelForTest.obj"));
        int count = objWritterTest.count(fileContent, "vt ");

        Assertions.assertEquals(count, model.textureVertices.size());
    }

    @Test
    public void objWritterTestCountNormals01() throws IOException {
        File fileStart = new File(String.valueOf(Path.of("ObjWritter/modelSave/modelForTest.obj")));
        if(fileStart.exists()){
            fileStart.delete();
        }
        ObjWritter.saveModel(model, "modelForTest");
        String fileContent = Files.readString(Path.of("ObjWritter/modelSave/modelForTest.obj"));
        int count = objWritterTest.count(fileContent, "vn ");

        Assertions.assertEquals(count, model.normals.size());
    }
    @Test
    public void objWritterTestCountPolygons01() throws IOException {
        File fileStart = new File(String.valueOf(Path.of("ObjWritter/modelSave/modelForTest.obj")));
        if(fileStart.exists()){
            fileStart.delete();
        }
        ObjWritter.saveModel(model, "modelForTest");
        String fileContent = Files.readString(Path.of("ObjWritter/modelSave/modelForTest.obj"));
        int count = objWritterTest.count(fileContent, "f ");

        Assertions.assertEquals(count, model.polygons.size());
    }

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }
}
