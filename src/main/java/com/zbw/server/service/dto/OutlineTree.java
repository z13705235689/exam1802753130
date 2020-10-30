package com.zbw.server.service.dto;

import java.util.List;

public class OutlineTree {
    private Long id;
    private Long chapter;
    private Long section;
    private Long outlineId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //是否为叶子结点
    private boolean leaf;
    //子结点
    private List<OutlineTree> children;

    public Long getChapter() {
        return chapter;
    }

    public void setChapter(Long chapter) {
        this.chapter = chapter;
    }

    public Long getSection() {
        return section;
    }

    public void setSection(Long section) {
        this.section = section;
    }

    public Long getOutlineId() {
        return outlineId;
    }

    public void setOutlineId(Long outlineId) {
        this.outlineId = outlineId;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<OutlineTree> getChildren() {
        return children;
    }

    public void setChildren(List<OutlineTree> children) {
        this.children = children;
    }
}
