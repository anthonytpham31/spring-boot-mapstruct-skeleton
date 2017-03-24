package cooksys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cooksys.entity.Tags;

public interface TagsRepository extends JpaRepository<Tags, Long>{

	Tags findByLabel(String label);
}
