package com.bestbuds.model;

import java.util.Objects;

public class Authority {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public Authority(
            String name
    ) {
        this.name = name;
    }

    @Override
    public boolean equals(
            Object object
    ) {

        if (this == object) {
            return true;
        }

        if (object == null
                || getClass() != object.getClass()) {
            return false;
        }

        Authority authority =
                (Authority) object;

        return Objects.equals(
                name,
                authority.name
        );
    }

    @Override
    public int hashCode() {

        return Objects.hash(
                name
        );
    }

    @Override
    public String toString() {

        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }
}