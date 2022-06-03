
export interface PlotLandConfiguration {
    plotLandId?: number | null;
    waterAmount: number;
    irrigationTimeSlot: number;
    nextIrrigationDate?: Date;
    status?: number;
}