package com.syphan.financial.app.provider.mysql.repository

import com.syphan.financial.app.provider.mysql.model.ScheduleModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ScheduleRepository : JpaRepository<ScheduleModel, UUID>
