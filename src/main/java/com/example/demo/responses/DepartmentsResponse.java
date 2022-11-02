package com.example.demo.responses;

import com.example.demo.dtos.DepartmentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentsResponse {

    private List<DepartmentDTO> contentDep;
    private int pageNoDep;
    private int pageSizeDep;
    private long totalElementsDep;
    private int totalPagesDep;
    private boolean lastDep;
}
