package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject: pupil.subjects()) {
                sum += subject.score();
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0D;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        int sum, count;
        for (Pupil pupil : pupils) {
            sum = 0;
            count = 0;
            for (Subject subject: pupil.subjects()) {
                sum += subject.score();
                count++;
            }
            list.add(new Label(pupil.name(), count > 0 ? (double) sum / count : 0D));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectsScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject: pupil.subjects()) {
                int score = subjectsScores.getOrDefault(subject.name(), 0);
                subjectsScores.put(subject.name(), score + subject.score());
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> subjectScore : subjectsScores.entrySet()) {
            labels.add(new Label(subjectScore.getKey(), (double) subjectScore.getValue() / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        int sum;
        for (Pupil pupil : pupils) {
            sum = 0;
            for (Subject subject: pupil.subjects()) {
                sum += subject.score();
            }
            labels.add(new Label(pupil.name(), sum));
        }
        Collections.sort(labels);
        return labels.size() > 0 ? labels.get(labels.size() - 1) : null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectsScores = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject: pupil.subjects()) {
                int score = subjectsScores.getOrDefault(subject.name(), 0);
                subjectsScores.put(subject.name(), score + subject.score());
            }
        }
        List<Label> labels = new ArrayList<>();
        for (Map.Entry<String, Integer> subjectScore : subjectsScores.entrySet()) {
            labels.add(new Label(subjectScore.getKey(), subjectScore.getValue()));
        }
        Collections.sort(labels);
        return labels.size() > 0 ? labels.get(labels.size() - 1) : null;
    }
}
