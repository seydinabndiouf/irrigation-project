import { AgriculturalCrop } from "./agricultural-crop.model";

export interface PlotLandConfiguration {
    plotLandId: number;
    waterAmount: number;
    irrigationTimeSlot: number;
    nextIrrigationDate: Date;
    status: number;
    agriculturalCrop: AgriculturalCrop
}