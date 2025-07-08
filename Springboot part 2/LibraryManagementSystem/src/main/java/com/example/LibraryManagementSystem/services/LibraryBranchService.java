package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.beans.LibraryBranch;
import com.example.LibraryManagementSystem.repos.LibraryBranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryBranchService implements LibraryBranchServiceInterface {

    @Autowired
    private LibraryBranchRepo branchRepo;

    @Override
    public List<LibraryBranch> getAllBranches() {
        return branchRepo.findAll();
    }

    @Override
    public LibraryBranch addLibraryBranch(LibraryBranch branch) {
        return branchRepo.save(branch);
    }

    @Override
    public Optional<LibraryBranch> findLibraryBranchById(int id) {
        return branchRepo.findById(id);
    }

    @Override
    public LibraryBranch getBranchById(int id) {
        return branchRepo.findById(id).orElse(null);
    }


    @Override
    public void deleteBranch(int id) {
        branchRepo.deleteById(id);
    }

    @Override
    public LibraryBranch updateBranch(LibraryBranch branch) {
        return branchRepo.save(branch);
    }
}
