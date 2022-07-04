package com.erickandedwin.usecase;

import org.jetbrains.annotations.NotNull;

public record Bursary(String name, String school,
                      String grade,
                      double income,
                      int parentStatus, double weightedMean) implements Comparable<Bursary>{
    public double weightedMean() {
        double weightedMean = (grade+ income+parentStatus )/3;
        return 0;
    }
        private int getGrade () {
            int g = 0;
            switch (grade) {
                case "A":
                    g = 12;
                case "A-":
                    g = 11;
                case "B+":
                    g = 10;
                case "B":
                    g = 9;
                case "B-":
                    g = 8;
                case "C+":
                    g = 7;
                case "C":
                    g = 6;
                case "C-":
                    g = 5;
                case "D+":
                    g = 4;
                case "D":
                    g = 3;
                case "D-":
                    g = 2;
                case "E":
                    g = 1;

            }
            return g;
        }
        private double getIncome () {
            int i = 0;
            if (income < 5000) {
                i = 12;
            }
            if ((5001 < income) < 10000) {
                i = 10;
            }
            if (income > 10000) {
                i = 8;
            }
            return i;

        }
        private int getParentStatus () {
            int p = 0;
            switch (parentStatus) {
                case "Orphan":
                    p = 12;
                case "not Orphan":
                    p = 6;
            }
            return p;
        }


        @Override
        public int compareTo (@NotNull Bursary o){
            int n = name.compareTo(o.name);
            if (n != 0) {
                return n;
            }
            int s = school.compareTo(o.school);
            if (s != 0) {
                return s;
            }
            int g = grade.compareTo(o.grade);
            if (g != 0) {
                return g;
            }
            double i = double.compare(income, o.income);

            if (i != 0) {
                return (int) i;
            }
            int p = Integer.compare(parentStatus, o.parentStatus);

            return p;
        }
        () {
            //weightedMean =  sum/a
            return 0;
        }
    }
