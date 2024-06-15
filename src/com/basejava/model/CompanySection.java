package com.basejava.model;

import java.util.List;
import java.util.Objects;

public class CompanySection extends Section {
    private final List<Company> company;

    public CompanySection(List<Company> company) {
        Objects.requireNonNull(company, "company cannot be null");
        this.company = company;
    }

    public List<Company> getCompany() {
        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanySection that = (CompanySection) o;

        return company.equals(that.company);
    }

    @Override
    public int hashCode() {
        return company.hashCode();
    }

    @Override
    public String toString() {
        return company.toString();
    }
}
