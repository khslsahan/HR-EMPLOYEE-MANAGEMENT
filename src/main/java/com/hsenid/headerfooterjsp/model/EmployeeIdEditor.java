package com.hsenid.headerfooterjsp.model;

import java.beans.PropertyEditorSupport;

public class EmployeeIdEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] parts = text.split("-");
        long id = Long.parseLong(parts[0]);
        long departmentId = Long.parseLong(parts[1]);
        setValue(new EmployeeId(id, departmentId));
    }

}
