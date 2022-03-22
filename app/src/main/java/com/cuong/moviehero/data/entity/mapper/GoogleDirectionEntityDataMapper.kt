package com.cuong.moviehero.data.entity.mapper

import com.cuong.moviehero.data.entity.google.GoogleDirectionEntity
import com.cuong.moviehero.domain.model.Direction
import com.cuong.moviehero.domain.model.GPSPoint
import com.cuong.moviehero.domain.model.Step
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoogleDirectionEntityDataMapper @Inject constructor() {
    fun transform(data: GoogleDirectionEntity) : Direction? {
        data.routes?.getOrNull(0)?.legs?.getOrNull(0)?.steps?.run {
            val steps: List<Step> = this.map {
                Step(
                    startPoint = GPSPoint(
                        it.startLocation?.lat ?: 0.0,
                        it.startLocation?.lng ?: 0.0,
                    ),
                    endPoint = GPSPoint(
                        it.endLocation?.lat ?: 0.0,
                        it.endLocation?.lng ?: 0.0,
                    ),
                )
            }

            val bounds = data.routes.getOrNull(0)?.bounds
            val northeastPoint = GPSPoint(
                bounds?.northeast?.lat ?: 0.0,
                bounds?.northeast?.lng ?: 0.0,
            )
            val southwestPoint = GPSPoint(
                bounds?.southwest?.lat ?: 0.0,
                bounds?.southwest?.lng ?: 0.0,
            )

            return Direction(
                steps = steps,
                northeastPoint = northeastPoint,
                southwestPoint = southwestPoint,
            )
        }

        return null
    }
}