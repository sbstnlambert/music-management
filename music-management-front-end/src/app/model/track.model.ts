export interface TrackSimple {
    id: number;
    name: String;
    numberOfLikes: number;
}

export interface TrackDetailed {
    id: number;
    name: string;
    lengthInSeconds: number;
    numberOfLikes: number;
    albumPosition: number;
}