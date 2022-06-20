   package com.example.fyp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {

}
