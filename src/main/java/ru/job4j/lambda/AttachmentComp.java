package ru.job4j.lambda;

import java.util.Comparator;

public class AttachmentComp implements Comparator<Attachment> {
    @Override
    public int compare(Attachment o1, Attachment o2) {
        return Integer.compare(o1.getSize(), o2.getSize());
    }
}
