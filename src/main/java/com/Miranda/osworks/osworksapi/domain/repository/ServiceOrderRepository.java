package com.Miranda.osworks.osworksapi.domain.repository;

import com.Miranda.osworks.osworksapi.domain.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceOrderRepository  extends JpaRepository<ServiceOrder, Long> {
}
