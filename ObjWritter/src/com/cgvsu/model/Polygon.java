package com.cgvsu.model;

import java.util.ArrayList;

public class Polygon {

    private ArrayList<Integer> vertexIndices;
    private ArrayList<Integer> textureVertexIndices;
    private ArrayList<Integer> normalIndices;


    public Polygon() {
        vertexIndices = new ArrayList<Integer>();
        textureVertexIndices = new ArrayList<Integer>();
        normalIndices = new ArrayList<Integer>();
    }

    public void setVertexIndices(ArrayList<Integer> vertexIndices) {
        assert vertexIndices.size() >= 3;
        this.vertexIndices = vertexIndices;
    }

    public void setTextureVertexIndices(ArrayList<Integer> textureVertexIndices) {
        assert textureVertexIndices.size() >= 3;
        this.textureVertexIndices = textureVertexIndices;
    }

    public void setNormalIndices(ArrayList<Integer> normalIndices) {
        assert normalIndices.size() >= 3;
        this.normalIndices = normalIndices;
    }

    public ArrayList<Integer> getVertexIndices() {
        return vertexIndices;
    }

    public ArrayList<Integer> getTextureVertexIndices() {
        return textureVertexIndices;
    }

    public ArrayList<Integer> getNormalIndices() {
        return normalIndices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<vertexIndices.size(); i++){
            sb.append(this.toStringPoligon(
                    vertexIndices.get(i),
                    textureVertexIndices.get(i),
                    normalIndices.get(i)
            ));

            sb.append(" ");
        }

        return sb.toString();
    }

    private String toStringPoligon(int v, int vt, int vn){
        StringBuilder sb = new StringBuilder();
        sb.append(v+1);

        if(vt == -1 & vn == -1){
            return sb.toString();
        }

        if(vt == -1 & vn != -1){
            sb.append("//");
            sb.append(vn+1);
            return sb.toString();
        }

        sb.append("/");
        sb.append(vt+1);

        if(vn == -1){
            return sb.toString();
        }

        sb.append("/");
        sb.append(vn+1);

        return sb.toString();

    }
}
