package com.syphan.financial.app.usecase

import com.syphan.financial.app.provider.mysql.model.toScheduleEntity
import com.syphan.financial.app.provider.mysql.model.toScheduleModel
import com.syphan.financial.app.provider.mysql.repository.ScheduleRepository
import com.syphan.financial.domain.command.CreateScheduleCommand
import com.syphan.financial.domain.entity.ScheduleEntity
import com.syphan.financial.domain.usecase.CreateScheduleUseCase
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CreateScheduleUseCaseImpl(
    private val scheduleRepository: ScheduleRepository,
) : CreateScheduleUseCase {
    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun execute(createScheduleCommand: CreateScheduleCommand): ScheduleEntity {
        logger.info("Creating schedule with command: $createScheduleCommand")
        val scheduleList = mutableListOf(createScheduleCommand)

        if (createScheduleCommand.numberOfRepetitions > 0) {
            for (n in 1..createScheduleCommand.numberOfRepetitions) {
                scheduleList.add(
                    createScheduleCommand.copy(
                        date =
                            createScheduleCommand.repetitionType?.calculateNextDate(createScheduleCommand.date, n)
                                ?: throw IllegalArgumentException(
                                    "Repetition type is required when number of repetitions is greater than 1",
                                ),
                    ),
                )
            }
        }

        return scheduleRepository
            .saveAll(scheduleList.map { it.toScheduleModel() })
            .map { it.toScheduleEntity() }
            .first()
    }
}
