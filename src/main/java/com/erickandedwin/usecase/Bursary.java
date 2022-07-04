package com.erickandedwin.usecase;

import org.jetbrains.annotations.NotNull;

public record Bursary(String name,
                      String school,
                      String grade,
                      double income,
                      String parentStatus) implements Comparable<Bursary>{
    public double weightedMean() {
        return (getGrade() + getIncome() + getParentStatus() )/3;
    }
        private int getGrade () {
            return switch (grade) {
                case "A" -> 12;
                case "A-" -> 11;
                case "B+" -> 10;
                case "B" -> 9;
                case "B-" -> 8;
                case "C+" -> 7;
                case "C" -> 6;
                case "C-" -> 5;
                case "D+" -> 4;
                case "D" -> 3;
                case "D-" -> 2;
                case "E" -> 1;
                default -> throw new IllegalArgumentException();
            };
        }
        private double getIncome () {
            int i = 0;
            if (income <= 5000) {
                i = 20;
            }
            else if ( income <= 10000) {
                i = 10;
            }
            else if(income > 10000) {
                i = 8;
            }
            return i;

        }
        private int getParentStatus () {
            return switch (parentStatus) {
                case "Orphan" -> 12;
                case "Not Orphan" -> 6;
                default -> throw new IllegalArgumentException("Unexpected value "+ parentStatus);
            };
        }


        @Override
        public int compareTo (@NotNull Bursary o) {
            int m = Double.compare(weightedMean(), o.weightedMean());
            if (m != 0) {
                return -m;
            }
            int n = name.compareTo(o.name);
            if (n != 0) {
                return n;
            }
            int s = school.compareTo(o.school);
            if (s != 0) {
                return s;
            }
            return grade.compareTo(o.grade);
        }

    }
