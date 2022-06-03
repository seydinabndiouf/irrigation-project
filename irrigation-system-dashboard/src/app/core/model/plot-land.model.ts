import { AgriculturalCrop } from "./plot-land/agricultural-crop.model";
import { PlotLandConfiguration } from "./plot-land/plot-land-configuration.model";

export interface PlotLand {
    plotLandId?: number | null;
    plotLandName: string;
    plotLandArea: number;
    plotLandConfiguration: PlotLandConfiguration;
    agriculturalCrop?: AgriculturalCrop

}