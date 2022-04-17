export interface TrackSimple {
    id: number;
    name: string;
    albumPosition: number;
    numberOfLikes: number;
}

export interface TrackDetailed {
    id: number;
    name: string;
    lengthInSeconds: number;
    numberOfLikes: number;
    artistName: string;
    albumName: string;
    albumGenres: Array<string>;
    videoUrl: string;
}

export interface TrackForm {
    name: string;
    lengthInSeconds: number;
    albumPosition: number;
    videoUrl: string;
    albumId: number;
}