package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.beans.LibraryBranch;
import java.util.List;
import java.util.Optional;

public interface LibraryBranchServiceInterface {
    Optional<LibraryBranch> findLibraryBranchById(int id);
    List<LibraryBranch> getAllBranches();
    LibraryBranch getBranchById(int id);
    LibraryBranch addLibraryBranch(LibraryBranch branch);
    void deleteBranch(int id);
    LibraryBranch updateBranch(LibraryBranch branch);
}
