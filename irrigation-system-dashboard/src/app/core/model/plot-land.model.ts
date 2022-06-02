import { PlotLandConfiguration } from "./plot-land/plot-land-configuration.model";

export interface PlotLand {
    plotLandId: number;
    plotLandName: string;
    plotLandArea: number;
    plotLandConfiguration: PlotLandConfiguration;
}