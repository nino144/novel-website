import { NovelPopularity } from "./novel-popularity";
import { NovelTraits } from "./novel-traits";

export interface Novel {
  imageURL: string;
  name: string;
  description?: string;
  author?: string;
  category?: string;
  chapter?: number;
  novelPopularity?: NovelPopularity;
  novelTraits?: NovelTraits;
}

